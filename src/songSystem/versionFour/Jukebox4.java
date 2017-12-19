package songSystem.versionFour;

import java.io.*;
import java.util.*;

/**
 * Created by 18435 on 2017/9/28.
 */
public class Jukebox4 {
    private ArrayList<Song> songList = new ArrayList<Song>();//仅将歌名cunzau数组中

    //列出所有歌名
    public void go() {
        getSongs();
        for (int i = 0; i < songList.size(); i++) {
            System.out.println("第" + (i + 1) + "首歌是:" + songList.get(i));
        }
        //实现以歌名排序
        TitleCompare titleCompare = new TitleCompare();
        Collections.sort(songList, titleCompare);
        for (int i = 0; i < songList.size(); i++) {
            System.out.println("第" + (i + 1) + "首歌是:" + songList.get(i));
        }
        Set<Song> songSet = new TreeSet<Song>();
        songSet.addAll(songList);
        System.out.println("去重的:\n" + songSet);
        //实现以歌手名排序
        ArtistCompare artistCompare = new ArtistCompare();
        Set<Song> songSet2 = new TreeSet<Song>(artistCompare);
        songSet2.addAll(songList);
        System.out.println("去重的:\n" + songSet2);

//        Collections.sort(songList,artistCompare);
//        for(int i=0;i<songList.size();i++){
//            System.out.println("第"+(i+1)+"首歌是:"+songList.get(i));
//        }
    }

    //读取文件 获取歌名，并将其放入集合中
    public void getSongs() {
        //通过获取classloader来获取resource文件
        InputStream is = Jukebox4.class.getClassLoader().getResourceAsStream("SongListMore.txt");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //将读出的一行数据添加到集合中
    public void addSong(String line) {
        String[] songDatas = line.split("/");
        Song song = new Song();
        song.setTitle(songDatas[0]);
        song.setArtist(songDatas[1]);
        song.setRating(songDatas[2]);
        song.setBpm(songDatas[3]);
        //song[0] 歌名   song[1] 歌星
        this.songList.add(song);
    }

    //内部类  实现排序规则
    class ArtistCompare implements Comparator<Song> {
        @Override
        public int compare(Song o1, Song o2) {//按歌手名排序
            return o1.getArtist().compareTo(o2.getArtist());
        }
    }

    class TitleCompare implements Comparator<Song> {
        @Override
        public int compare(Song o1, Song o2) {//以歌名排序
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }

    public static void main(String[] args) {
        Jukebox4 jukebox4 = new Jukebox4();
        jukebox4.go();
    }
}
