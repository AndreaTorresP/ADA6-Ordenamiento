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
    private int length;
    private int acousticness;
    private int speechiness;
    private int popularity;

    public spotify(int id, String name, String artist, String genre, int beats, int energy, int danceability,
        int loudness, int liveness, int valence, int length, int acousticness, int speechiness, int popularity) {
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
        this.length = length;
        this.acousticness = acousticness;
        this.speechiness = speechiness;
        this.popularity = popularity;
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

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public int getAcousticness() {
        return acousticness;
    }
    public void setAcousticness(int acousticness) {
        this.acousticness = acousticness;
    }

    public int getSpeechiness() {
        return speechiness;
    }
    public void setSpeechiness(int speechiness) {
        this.speechiness = speechiness;
    }

    public int getPopularity() {
        return popularity;
    }
    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String display() {
        return "{\nid: " + getId() + "\nName:" + getName() + "\nArtist: " + getArtist() + "\nGenre: " + getGenre()
                + "\nBeats: " + getBeats() + "\nEnergy: " + getEnergy() + "\nDanceability: " + getDanceability()
                + "\nLoudness: " + getLoudness() + "\nLiveness: " + getLiveness() + "\nValence: " + getValence()
                + "\nLenght: " + getLength() + "\nAcousticness: " + getAcousticness() + "\nSpeechiness: "
                + getSpeechiness() + "\nPopularity: " + getPopularity() + "\n}";
    }
}
