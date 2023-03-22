package mode1;

public class spotify {
    private int id;
    private String name;
    private String artist;
    private String genre;
    private int beats;
    private int energy;
    private int danceability;
    private int loudness;
    private int liveness;
    private int valence;

    public spotify(int id, String name, String artist, String genre, int beats, int energy, int danceability,
            int loudness, int liveness, int valence) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.beats = beats;
        this.energy = energy;
        this.danceability = danceability;
        this.loudness = loudness;
        this.liveness = liveness;
        this.valence = valence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getBeats() {
        return beats;
    }

    public void setBeats(int beats) {
        this.beats = beats;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getDanceability() {
        return danceability;
    }

    public void setDanceability(int danceability) {
        this.danceability = danceability;
    }

    public int getLoudness() {
        return loudness;
    }

    public void setLoudness(int loudness) {
        this.loudness = loudness;
    }

    public int getLiveness() {
        return liveness;
    }

    public void setLiveness(int liveness) {
        this.liveness = liveness;
    }

    public int getValence() {
        return valence;
    }

    public void setValence(int valence) {
        this.valence = valence;
    }

}
