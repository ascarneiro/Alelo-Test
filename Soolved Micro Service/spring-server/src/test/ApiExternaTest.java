
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.client.WireMockBuilder;
import com.github.tomakehurst.wiremock.http.HttpHeader;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.security.ClientAuthenticator;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
@SpringBootTest
public class ApiExternaTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);

    @Test
    public void testeApiExternaWireMock() {

        WireMock wm = new WireMockBuilder()
                .scheme("https")
                .host("ascarneiro.mocklab.io")
                .port(443)
                .authenticator(new ClientAuthenticator() {
                    @Override
                    public List<HttpHeader> generateAuthHeaders() {
                        return Collections.singletonList(new HttpHeader("Authorization", "Token 71ecd833ccd2ee8576cf519a2c1aca15"));
                    }
                })
                .build();


        // Configure a stub
        wm.register(get(urlEqualTo("/hello-world"))
                .willReturn(aResponse().withBody("Hi!")));
    }
}
