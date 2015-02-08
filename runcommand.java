import java.io.*;

public class runcommand {

	public static void main(String args[]) {

		String s = null;

		try {

			// "pwd" komutu calistiriyoruz
			// Runtime exec metodu kullanilir
			Process p = Runtime.getRuntime().exec("pwd");

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(
					p.getInputStream()));

			BufferedReader stdError = new BufferedReader(new InputStreamReader(
					p.getErrorStream()));

			// komutun ciktisi
			System.out.println("Komutun Ciktisi >> \n --- \n");
			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
			}

			// Hatalari oku!
			System.out.println("Eger Varsa komutun hatalari!!\n --- \n");
			while ((s = stdError.readLine()) != null) {
				System.out.println(s);
			}

			System.exit(0);
		} catch (IOException e) {
			System.out.println("Çakışma oldu burada yazıyor >> ");
			e.printStackTrace();
			System.exit(-1);
		}
	}
}