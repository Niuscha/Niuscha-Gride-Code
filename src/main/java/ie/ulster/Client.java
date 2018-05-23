package ie.ulster;

class Client

{
    
    private String Id;
    private String First_Name;
    private String Last_Name;
    private String city;
    private boolean paid;
    private int amount;


    public Client (String pId, String pFirst_Name, String pLast_Name, String pCity, boolean pPaid, int pAmount) {

        this.Id = pId;
        this.First_Name = pFirst_Name;
        this.Last_Name = pLast_Name;
        this.city = pCity;
        this.paid = pPaid;
        this.amount = pAmount; 
    }   

    /**
     * @return the id
     */
    public String getId() {
        return Id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.Id = id;
    }


    /**
     * @return the first_Name
     */
    public String getFirst_Name() {
        return First_Name;
    }

    /**
     * @param first_Name the first_Name to set
     */
    public void setFirst_Name(String first_Name) {
        this.First_Name = first_Name;
    }

    /**
     * @return the last_Name
     */
    public String getLast_Name() {
        return Last_Name;
    }

    /**
     * @param last_Name the last_Name to set
     */
    public void setLast_Name(String last_Name) {
        this.Last_Name = last_Name;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the paid
     */
    public boolean isPaid() {
        return paid;
    }

    /**
     * @param paid the paid to set
     */
    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}




