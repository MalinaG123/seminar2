package ro.ase.cts.lab02;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        OShop o = new OShop("Emag", "logo.jpg", new ArrayList<Prod>());

        Prod p1 = new Prod("Laptop", 3200.5, 1,1, 1123, "");
        Prod p2 = new Prod("Frigider", 207.95, 1,2, 1245, "");

        Prod p3 = new Prod(p1);

        p3.setQty(5);
        p3.setProdName("Paine");

        o.modifyProductsList(1,p1);
        o.modifyProductsList(1,p2);

        o.modifyProductsList(2, p1);
        System.out.println(p1.equals(p2));
    }
}

class OShop {
    private String onlineShopName;
    private String i;
    private ArrayList<Prod> products;
    //aici trebuie sa retinem cantitate, sa folosim un map intre id si cantitate produs si trebuie modificat stocul

    OShop(String name, String img, ArrayList<Prod> products)
    {
        this.products = new ArrayList<Prod>();
        this.i = img;
        this.onlineShopName = name;
    }

    public void modifyProductsList(int what, Prod p)
    {
        if(what == 1)
        {
            this.products.add(p);
        }
        else
            this.products.remove(p);
    }

    public String getOnlineShopName() {
        return onlineShopName;
    }

    public void setOnlineShopName(String onlineShopName) {
        this.onlineShopName = onlineShopName;
    }

    public String getI() {
        return i;
    }

    public void setImg(String img) {
        this.i = img;
    }
}

class Product
{
    private int id;
    private String name;
    private double price;
    private Category category; //il facem enum

    private String details; // ex.: processor, memory, power, volume (for refrigerators etc)

    public Product(int id,String name, double price, Category category, int quantity, String details)
    {
        //adaugam validari (pt pret, categorie,nume,etc)
        if(id>0){
            this.id = id;
        }else{
            //punem exceptii personalizate
        }
        if(name.length()>=5){
            this.name = name;
        }else{
            //pune exceptii personalizate(MinLength)
        }
        if(price > 0){
            this.price = price;
        }else{
            //exceptie
        }
        this.category = category;
        if (quantity > 0){
            this.quantity = quantity;
        }else{
            //exceptie
        }
        this.details = details;
    }

    public Product(Product p)
    {
        //apelam constructorul cu par
        this(p.id,p.name,p.price,p.category,p.quantity,p.details);
    }

    //facem getteri si setteri doar daca avem nevoie de ei, altfel nu ii scriem

    public boolean equals(Product p)
    {
        //din toate if astea facem unul singur cu &&
        if(p.id != this.id && p.name != this.name && p.price != this.price && p.quantity != this.quantity && )
            return false;
        if(!p.prodName.equals(this.prodName))
            return false;
        if(p.productPrice != this.productPrice)
            return false;
        if(p.productType != p.productType)
            return false;
        if(p.productCategory != this.productCategory)
            return false;

        return true;
    }

    //met asta ar trebui inlocuita cu 2 met, una care face scumpirea(raisePrice() si una care face ieftinirea(applyDiscount())
    //prima oara ver daca val corespunde unui procent(adica are val intre 0 si 1)
    public void modify(boolean flag, double val)
    {
        if(flag)
            this.productPrice+=this.productPrice*val;
        if(!flag)
            this.productPrice-=this.productPrice*val/100;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
//!!!!! nu se declara variabile pt chestii care se pot calcula !!!!!

class User
{
    private String usn;
    private String userId;
    private ArrayList<Order> o;//order facem alta clasa(lista produse, adresa de livrare
    private Cart c;//cart pt cart facem alta clasa(cont lista produse

    public User(String usn, String userId)
    {
        this.usn = usn;
        this.userId = userId;
        o=new ArrayList<Order>();
        c=new ArrayList<Order>();
    }

    //plaseaza comanda(cand se plaseaza comanda se si goleste cosul)
    public void addO1(Order o)
    {
        this.o.add(o);
    }
    //met de adauga ob in cos
    public void addO2(Order o)
    {
        this.c.add(o);
    }
}

class Order
{
    private ArrayList<Prod> l;
    private String addr;

    public Order()
    {
        l = new ArrayList<Prod>();
    }
    public void add(Prod p)
    {
        if(l.size() > 99)
            return;

        l.add(p);
    }

    public void remove(Prod p)
    {
        l.remove(p);
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}

class InventoryP
{
    private Prod p;
    private int q;

    public InventoryP(Prod p, int q)
    {
        this.p = new Prod(p);
        this.q = q;
    }
    public Prod getP() {
        return p;
    }

    public void setP(Prod p) {
        this.p = p;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }
}



