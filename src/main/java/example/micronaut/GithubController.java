package example.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

@Controller()
public class GithubController {

	@Get("/test")
	Single<String> test() {
		return Single.just("OK");
	}
}