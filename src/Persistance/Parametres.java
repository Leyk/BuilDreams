package Persistance;

public class Parametres {
	 private String url;
	 private String username;
	 private String password;
	 
	 public Parametres (){
		 url = "jdbc:postgresql://ec2-54-83-17-9.compute-1.amazonaws.com:5432/dllglgnl3bmq5?sslmode=require";
		 username = "rxpriwcmpcikoe";  
		 password ="HVn1MiRMKwVlj8kVMvMFcZF9OC";
	 }
	 

	 public String getURL() {
	  return url;
	 }
	 public String getUsername() {
	  return username;
	 }
	 public String getPassword() {
	  return password;
	 }
	 
	 
	 
	 /* Cette classe est uniquement pr�sente pour externaliser les param�tres de connexion � la base de donn�es postgr� */
	 /* Construction avec ces attributs */
	 /* Accesseurs sur les attributs de connexion */
}
