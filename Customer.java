
public record Customer(String id, String firstname, String lastname, String email, double balance) {
	public String toString() {
		return "\nStudent: " + firstname + " " + lastname + "\nID: " + id + "\nEmail: " + email + "\nBalance: " + balance;
	}
	
	public boolean equals(String id) { //for searching
		return this.id == id;
	}
}
