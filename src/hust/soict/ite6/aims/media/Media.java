package hust.soict.ite6.aims.media;

import java.util.Comparator;
import java.util.Objects;

public class Media {
    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    
    public Media() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Media other = (Media) obj;
        return Objects.equals(title, other.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    // MediaComparatorByCostTitle class - non-public
    static class MediaComparatorByCostTitle implements Comparator<Media> {
        @Override
        public int compare(Media m1, Media m2) {
            int costComparison = Double.compare(m2.getCost(), m1.getCost());
            if (costComparison != 0) {
                return costComparison;
            }
            return m1.getTitle().compareTo(m2.getTitle());
        }
    }

    // MediaComparatorByTitleCost class - non-public
    static class MediaComparatorByTitleCost implements Comparator<Media> {
        @Override
        public int compare(Media m1, Media m2) {
            int titleComparison = m1.getTitle().compareTo(m2.getTitle());
            if (titleComparison != 0) {
                return titleComparison;
            }
            return Double.compare(m1.getCost(), m2.getCost());
        }
    }
}
