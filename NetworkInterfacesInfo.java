import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.*;

/* author : Mohamed Elmaghraby */

public class NetworkInterfacesInfo {

	public static void main(String[] args) throws SocketException {

		HashMap<String, List<String>> nifMap = new HashMap<String, List<String>>();
		Enumeration<NetworkInterface> listNIF = NetworkInterface.getNetworkInterfaces();

		while (listNIF.hasMoreElements()) {

			List<String> mapValue = new ArrayList<String>();
			String key;
			NetworkInterface nif = listNIF.nextElement();
			key = nif.getName();
			mapValue.add("HardwareAddress : " + nif.getHardwareAddress());
			mapValue.add("Index : " + nif.getIndex());
			mapValue.add("Parent : " + nif.getParent() + "");
			mapValue.add("isVirtual : " + nif.isVirtual() + "");
			mapValue.add("isLoopback : " + nif.isLoopback() + "");
			mapValue.add("isPointToPoint : " + nif.isPointToPoint() + "");
			nifMap.put(key, mapValue);

		}

		Set set = nifMap.entrySet();
		// Get an iterator
		Iterator i = set.iterator();

		// Display elements
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			System.out.print(me.getKey() + "=> ( ");
			nifMap.get(me.getKey()).forEach(x -> System.out.print(x + " ,"));
			System.out.println(")");
		}

	}

}
