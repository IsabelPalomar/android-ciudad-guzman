package android.example.com.feriaciudadguzman.models;


public class Event {

    private String name;
    private String description;
    private String url;
    private int imageId;

    public Event(String name, String description, String url, int imageId) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public int getImageId() {
        return imageId;
    }

}
