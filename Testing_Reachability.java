import java.io.IOException;
import java.net.InetAddress;

public class TestingReachability {

	public static void main(String[] args) throws IOException {

		String url = "www.yahoo.com";
		// get all ip addresses of this url
		InetAddress[] addresses = InetAddress.getAllByName(url);

		for (InetAddress inet : addresses) {
			// ping all ip of this server
			if (inet.isReachable(10000)) {
				System.out.println(inet + " is reachable");

			} else {

				System.out.println(inet + " is not reachable");

			}

		}

	}

}
