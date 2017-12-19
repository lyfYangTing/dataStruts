package songSystem.versiontwo;

/**
 * Created by 18435 on 2017/9/27.
 */
public class Song implements Comparable<Song>{//必须指明泛型为Song 因为只有同类型的数据才可以比较大小
    @Override
    public int compareTo(Song o) {////返回负数值表示传入的Song大于执行的Song
        return this.title.compareTo(o.getTitle());//按照歌名来排序
    }

    private String title;
    private String artist;
    private String rating;
    private String bpm;

    @Override
    public String toString() {
        return this.title;//返回歌名
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getBpm() {
        return bpm;
    }

    public void setBpm(String bpm) {
        this.bpm = bpm;
    }
}
