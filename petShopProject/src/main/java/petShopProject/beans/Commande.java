package petShopProject.beans;

public class Commande {
 private String email, item_pic,item_name,devise;
 public String getDevise() {
	return devise;
}

public void setDevise(String devise) {
	this.devise = devise;
}

private int id, quantite;
 private float price;
public float getPrice() {
	return price;
}

public void setPrice(float price) {
	this.price = price;
}

public int getQuantite() {
	return quantite;
}

public void setQuantite(int quantite) {
	this.quantite = quantite;
}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getItem_pic() {
	return item_pic;
}

public void setItem_pic(String item_pic) {
	this.item_pic = item_pic;
}

public String getItem_name() {
	return item_name;
}

public void setItem_name(String item_name) {
	this.item_name = item_name;
}




 
	
	
}
