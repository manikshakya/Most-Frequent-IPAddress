import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IPAddressCounter {

	public static final String LOG_CONTENT =
			  "188.191.254.20,[22/Mar/2009:07:00:32 +0100],188.191.254.21,GET / HTTP/1.0,200\n"
			+ "166.249.66.231,[22/Mar/2009:07:06:20 +0100],188.191.254.20,GET / HTTP/1.1,200\n"
			+ "166.249.66.231,[22/Mar/2009:07:11:20 +0100],188.191.254.20,188.191.254.20,GET / HTTP/1.1,200\n"
			+ "183.198.25.175,[22/Mar/2009:07:40:06 +0100],188.191.254.20,GET / HTTP/1.1,200\n"
			+ "183.198.25.175,[22/Mar/2009:07:40:06 +0100],188.191.254.20,GET /style.css HTTP/1.1,200\n"
			+ "183.198.25.175,[22/Mar/2009:07:40:06 +0100],188.191.254.20,GET /images/ht1.gif HTTP/1.1,200\n"
			+ "183.198.25.175,[22/Mar/2009:07:40:06 +0100],188.191.254.20,GET /images/ht2.gif HTTP/1.1,200\n"
			+ "183.198.25.175,[22/Mar/2009:07:40:06 +0100],188.191.254.20,GET /images/en.jpg HTTP/1.1,200\n"
			+ "183.198.25.175,[22/Mar/2009:07:40:06 +0100],188.191.254.20,GET /images/bt_qui.gif HTTP/1.1,200\n"
			+ "183.198.25.175,[22/Mar/2009:07:40:06 +0100],188.191.254.20,GET /images/bt_references.gif HTTP/1.1,200\n"
			+ "183.198.25.175,[22/Mar/2009:07:40:06 +0100],188.191.254.20,GET /images/bt_contacts.gif HTTP/1.1,200\n"
			+ "183.198.25.175,[22/Mar/2009:07:40:06 +0100],188.191.254.20,GET /images/ht3.gif HTTP/1.1,200\n"
			+ "183.198.25.175,[22/Mar/2009:07:40:06 +0100],188.191.254.20,GET /images/vide.gif HTTP/1.1,200\n"
			+ "183.198.25.175,[22/Mar/2009:07:40:06 +0100],188.191.254.20,GET /images/ht4.gif HTTP/1.1,200\n"
			+ "183.198.25.175,[22/Mar/2009:07:40:06 +0100],188.191.254.20,GET /images/contact.gif HTTP/1.1,200\n"
			+ "183.198.25.175,[22/Mar/2009:07:40:06 +0100],188.191.254.20,GET /images/puce.gif HTTP/1.1,200\n"
			+ "183.198.25.175,[22/Mar/2009:07:40:06 +0100],188.191.254.20,GET /images/h_facades.gif HTTP/1.1,200\n"
			+ "183.198.25.175,[22/Mar/2009:07:40:06 +0100],188.191.254.20,GET /images/f_blanc.gif HTTP/1.1,200\n"
			+ "183.198.25.175,[22/Mar/2009:07:40:07 +0100],188.191.254.20,GET /images/bt_mail.gif HTTP/1.1,200\n"
			+ "183.198.25.175,[22/Mar/2009:07:40:07 +0100],188.191.254.20,GET /images/v_home_1.gif HTTP/1.1,200\n"
			+ "183.198.25.175,[22/Mar/2009:07:40:07 +0100],188.191.254.20,GET /favicon.ico HTTP/1.1,404\n"
			+ "188.191.254.20,[22/Mar/2009:07:50:33 +0100],188.191.254.21,GET / HTTP/1.0,200\n"
			+ "188.191.254.20,[22/Mar/2009:08:40:32 +0100],188.191.254.21,GET / HTTP/1.0,200\n"
			+ "185.114.141.210,[22/Mar/2009:08:54:11 +0100],188.191.254.20,GET / HTTP/1.1,200\n"
			+ "188.191.254.20,[22/Mar/2009:09:30:31 +0100],188.191.254.20,GET / HTTP/1.0,200\n"
			+ "185.214.36.20,[22/Mar/2009:09:30:51 +0100],188.191.254.20,GET / HTTP/1.1,200\n"
			+ "182.249.2.69,[22/Mar/2009:09:32:23 +0100],188.191.254.20,GET / HTTP/1.1,200\n"
			+ "29.120.218.236,[22/Mar/2009:09:37:19 +0100],188.191.254.21,HEAD / HTTP/1.1,200\n"
			+ "29.120.218.236,[22/Mar/2009:09:37:19 +0100],188.191.254.21,GET / HTTP/1.1,200\n"
			+ "29.120.218.236,[22/Mar/2009:09:37:19 +0100],188.191.254.21,GET / HTTP/1.1,200";

	public static class IPCount {
		public String ipAddress;
		public int count;
	}

	public static IPCount findMostFrequentIP(String log) {
		//throw new UnsupportedOperationException("Waiting to be implemented.");
		
		String s = log;
		
		String[] lines = s.split("\n");
		String[] ip = new String[lines.length];
		int c = 0;
		for(String s1 : lines) {
			ip[c] = s1.substring(0, s1.indexOf(','));
			c++;
			//System.out.println(s1.substring(0, s1.indexOf(',')));
			
		}
		
		Set<String> set = new HashSet<>(Arrays.asList(ip));
		
//		System.out.println(set);
		
		
		
		String re = "";
		int total = 0;
		
		for(String s1 : set) {
			
			int count = 0;
			String temp = s1;
			for(int i = 0; i < ip.length; i++) {
				if(temp.equals(ip[i])) {
					count++;
				}
			}
			
			if(count > total) {
				total = count;
				re = temp;
			}
		}
//		System.out.println(re + ": "+ total);
		
		
		IPCount temp = new IPCount();
		temp.ipAddress = re;
		temp.count = total;
		
		
		return temp;
	}

	public static void main(String[] args) {
		IPCount ipcount = findMostFrequentIP(LOG_CONTENT);
		System.out.println("IP address: " + ipcount.ipAddress);
		System.out.println("Occurrence: " + ipcount.count);
	}
}


