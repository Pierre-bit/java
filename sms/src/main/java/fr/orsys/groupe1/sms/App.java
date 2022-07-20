package fr.orsys.groupe1.sms;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App 
{	 //https://api.ovh.com/console/#/sms/{serviceName}/jobs
	private static final String SERVICENAME = "sms-cf678891-1";

    // Application Key
    protected static String AK = "a38e0bd7725e20b2";

    // Application Secret
    protected static String AS = "d303ba5f92c1badb40eab91cc7bdf822";

    // Consumer Key
    protected static String CK = "8b635dd7c4c2dcc2cb7586f4090c37da";
    private static String numeroDestinataire;
	private static Scanner sc = new Scanner(System.in);
	private static String messageAEnvoyer;
	
	 public static void main (String[] args)
	    {
	    	//System.out.println( "Hello World!" );
	        System.out.println("Merci d'indiquez le numero de téléphone du destinataire "
	        		+ "en commençant par +336 ou +337");
	        numeroDestinataire = sc.nextLine();
	        System.out.println("merci de saisir un message");
	        messageAEnvoyer = sc.nextLine(); 
	        
	        
	        sendSms();
	        sc.close();
	    }
	
	
	public static void sendSms()
	{
		
	    // type de requete
	    String METHOD = "POST";
	   
	    try {
	    	URL QUERY  = new URL("https://eu.api.ovh.com/1.0/sms/"+SERVICENAME+"/jobs");
	    	// instanciation d'un objetMapper liéee a la classe jackson pour parse en json
	    	ObjectMapper objectMapper = new ObjectMapper();
	    	// instanciation de la classe Message 
	    	Message message = new Message( messageAEnvoyer,new String[] {numeroDestinataire}, "high", true);
	    	// parsage du message en json 
	    	String 	BODY = objectMapper.writeValueAsString(message);
	    	
	    	
	    	// creration du timestamp
	    	long TSTAMP  = new Date().getTime()/1000;

	        //Création de la signature
	        String toSign    = AS + "+" + CK + "+" + METHOD + "+" + QUERY + "+" + BODY + "+" + TSTAMP;
	        String signature = "$1$" + HashSHA1(toSign);
	        System.out.println(signature);
	        
	        // corps de la requete 
	        HttpURLConnection req = (HttpURLConnection)QUERY.openConnection();
	        req.setRequestMethod(METHOD);
	        req.setRequestProperty("Content-Type",      "application/json");
	        req.setRequestProperty("X-Ovh-Application", AK);
	        req.setRequestProperty("X-Ovh-Consumer",    CK);
	        req.setRequestProperty("X-Ovh-Signature",   signature);
	        req.setRequestProperty("X-Ovh-Timestamp",   "" + TSTAMP);

	        // verification si le body est vide 
	        if(!BODY.isEmpty())
	        {
	            req.setDoOutput(true);
	            DataOutputStream wr = new DataOutputStream(req.getOutputStream());
	            wr.writeBytes(BODY);
	            wr.flush();
	            wr.close();
	        }

            String inputLine;
            BufferedReader in;
            int responseCode = req.getResponseCode();
            if ( responseCode == 200 )
            {
                //Récupération du résultat de l'appel
                in = new BufferedReader(new InputStreamReader(req.getInputStream()));
            }
            else
            {
                in = new BufferedReader(new InputStreamReader(req.getErrorStream()));
            }
            StringBuffer response   = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //Affichage du résultat     
            System.out.println(response.toString());
		        
		        // merci de consulter le guide d'OVH
		        

		        ///sms/{serviceName}/jobs
		} catch (MalformedURLException e) {
            final String errmsg = "MalformedURLException: " + e;
        } catch (IOException e) {
            final String errmsg = "IOException: " + e;
        }
	}
	
		// creation de la méthode de hachage sha1 
	 public static String HashSHA1(String text) 
	    {
	        MessageDigest md;
	        try {
	            md = MessageDigest.getInstance("SHA-1");
	            byte[] sha1hash = new byte[40];
	            md.update(text.getBytes("iso-8859-1"), 0, text.length());
	            sha1hash = md.digest();
	            return convertToHex(sha1hash);
	        } catch (NoSuchAlgorithmException e) {
	            final String errmsg = "NoSuchAlgorithmException: " + text + " " + e;
	            return errmsg;
	        } catch (UnsupportedEncodingException e) {
	            final String errmsg = "UnsupportedEncodingException: " + text + " " + e;
	            return errmsg;
	        }
	    }
	 	// methode pour convertir en he
	    private static String convertToHex(byte[] data)
	    { 
	        StringBuffer buf = new StringBuffer();
	        for (int i = 0; i < data.length; i++) { 
	            int halfbyte = (data[i] >>> 4) & 0x0F;
	            int two_halfs = 0;
	            do { 
	                if ((0 <= halfbyte) && (halfbyte <= 9)) 
	                    buf.append((char) ('0' + halfbyte));
	                else 
	                    buf.append((char) ('a' + (halfbyte - 10)));
	                halfbyte = data[i] & 0x0F;
	            } while(two_halfs++ < 1);
	        } 
	        return buf.toString();
	    }
    
}
