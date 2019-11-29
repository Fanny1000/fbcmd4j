package fbcmd4j;


import java.net.MalformedURLException;
import java.net.URL;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.auth.AccessToken;

public class cmd4j {
private static String appId="2404212626466672";
private static String appSecret="38ce1a1315fdf9d989d083b3be7ce8a7";
private static String accessToken="EAAiKnlZBQp3ABAD7X1DyAwoaCnK00cj6wCrJJ8amF8bMSHDx4X3IhfaIc6JMXUTt3wNxn8QeLrZBbz9MWHPefOzMbpFVtzAFVCZBI9lB5adnJZAFEhboOebYH5mRVfRalZAwtRLyK35WJ80z7Gwy4VZBdGR9LwzNsg4oynycZBozVxvZCstLmaLUr5RLkBAcuSK03T5nMZAww1abkk7Bb40jkevZBnRoTaAXuu16eJZB7VJGAZDZD";

public static void main (String[] args) throws FacebookException, MalformedURLException{
	Facebook facebook=new FacebookFactory().getInstance();
	facebook.setOAuthAppId(appId, appSecret);
	
	facebook.setOAuthAccessToken(
			new AccessToken(accessToken,null));
	
	//Mi info
	User user=facebook.getMe();
	System.out.println("Mi nombre: ");
	System.out.println("\t"+user.getName());
	
	//publicar post
	PostUpdate post= new PostUpdate(new URL("http://facebook.org"))
			.name("Facebook4J - A Java library for the Facebook Graph API")
			.caption("facebook.org")
			.description("Facebook4J is a Java library for the Facebook Graph API.");
	facebook.postFeed(post);
	
	//buscar personas
	ResponseList<User> results=facebook.searchUsers("LuisMi");
	System.out.println("Búsqueda de personas con nombre LuisMi");
	for (int i=0;i<results.size();i++) {
		User u=results.get(i);
		System.out.println("\t"+u.getName());
	}
	
	//post con una o varias palabras
	ResponseList<Post> results2=facebook.searchPosts("Atleti");
	System.out.println("Búsqueda de post sobre Atleti");
	for (int i=0;i<results2.size();i++) {
		Post p=results2.get(i);
		System.out.println("\t"+p.getMessage());
	}
	
}
}
