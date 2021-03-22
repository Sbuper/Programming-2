package movies;

/**
 *
 * @author aryan1798
 * Jan 18
 */
public class Movies {
    
    private String leading_man;
    private String leading_woman;
    private int length;
    private double stars;      //popularity rating
    private String rating;  //MPAA rating of the movie
    
    
    public Movies() {
        leading_man = "unkown";
        leading_woman = "unkown";
        stars = 0.0;
        rating = "PG-13";
    }

    public Movies(String lm, String lw, int len, double st, String rate) {
        leading_man = lm;
        leading_woman = lw;
        length = len;
        stars = st;
        rating = rate;
    }

    public String getLeading_man() {
        return leading_man;
    }

    public void setLeading_man(String lm) {
        leading_man = lm;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double st) {
        stars = st;
    }
    
    
    
    
}
