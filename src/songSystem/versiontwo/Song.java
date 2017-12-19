package songSystem.versiontwo;

/**
 * Created by 18435 on 2017/9/27.
 */
public class Song implements Comparable<Song>{//����ָ������ΪSong ��Ϊֻ��ͬ���͵����ݲſ��ԱȽϴ�С
    @Override
    public int compareTo(Song o) {////���ظ���ֵ��ʾ�����Song����ִ�е�Song
        return this.title.compareTo(o.getTitle());//���ո���������
    }

    private String title;
    private String artist;
    private String rating;
    private String bpm;

    @Override
    public String toString() {
        return this.title;//���ظ���
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
