package lab6;

import org.slf4j.MDC;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class MonoDefer {
    public Mono<PaymentResponse> callPartnerApi(PaymentRequest req) {
        Map<String, String> mdcContext = MDC.getCopyOfContextMap();

        return Mono.defer(() -> {
            if (mdcContext != null) MDC.setContextMap(mdcContext);

            long now = System.currentTimeMillis();
            String freshSignature = sign(req, now);

            WebClient webClient = WebClient.create("http://partner-api.com/payment");
            return webClient.post().header("X-Timestamp", String.valueOf(now)).header("X-Signature", freshSignature)
                    .bodyValue(req) // Đảm bảo req là POJO tĩnh, không phải Stream
                    .retrieve().bodyToMono(PaymentResponse.class);

        }).timeout(Duration.ofSeconds(5)).retryWhen(Retry.backoff(3, Duration.ofSeconds(2)).filter(throwable -> {
            if (throwable instanceof WebClientResponseException) {
                WebClientResponseException ex = (WebClientResponseException) throwable;
                return ex.getStatusCode().is5xxServerError(); // Bỏ qua 4xx
            }
            return throwable instanceof TimeoutException || throwable instanceof IOException;
        })).doFinally(signalType -> MDC.clear()); // Dọn dẹp bộ nhớ Log
    }

    private String sign(PaymentRequest req, long now) {
        return null;
    }
}
