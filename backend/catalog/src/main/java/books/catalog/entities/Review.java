package books.catalog.entities;

public class Review {
    
    private Users reviewer;
    private String review;
    private int rating;
    
    public Review() {}
    
    public Review(Users reviewer, String review, int rating) {
        this.reviewer = reviewer;
        this.review = review;
        this.rating = rating;
    }
    
    public Users getReviewer() {
        return reviewer;
    }
    
    public String getReview() {
        return review;
    }
    
    public int getRating() {
        return rating;
    }
    
    public void setReviewer(Users reviewer) {
        this.reviewer = reviewer;
    }
    
    public void setReview(String review) {
        this.review = review;
    }
    
    public void setRating(int rating) {
        this.rating = rating;
    }
}
