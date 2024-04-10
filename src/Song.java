public class Song {
    private String songtitle;
    private double duration;

    public Song() {
    }

    public Song(String songtitle, double duration) {
        this.songtitle = songtitle;
        this.duration = duration;
    }

    public String getSongtitle() {
        return songtitle;
    }

    public void setSongtitle(String songtitle) {
        this.songtitle = songtitle;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songtitle='" + songtitle + '\'' +
                ", duration=" + duration +
                '}';
    }
}
