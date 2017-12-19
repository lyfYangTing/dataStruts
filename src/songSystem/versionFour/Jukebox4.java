package songSystem.versionFour;

import java.io.*;
import java.util.*;

/**
 * Created by 18435 on 2017/9/28.
 */
public class Jukebox4 {
    private ArrayList<Song> songList = new ArrayList<Song>();//��������cunzau������

    //�г����и���
    public void go() {
        getSongs();
        for (int i = 0; i < songList.size(); i++) {
            System.out.println("��" + (i + 1) + "�׸���:" + songList.get(i));
        }
        //ʵ���Ը�������
        TitleCompare titleCompare = new TitleCompare();
        Collections.sort(songList, titleCompare);
        for (int i = 0; i < songList.size(); i++) {
            System.out.println("��" + (i + 1) + "�׸���:" + songList.get(i));
        }
        Set<Song> songSet = new TreeSet<Song>();
        songSet.addAll(songList);
        System.out.println("ȥ�ص�:\n" + songSet);
        //ʵ���Ը���������
        ArtistCompare artistCompare = new ArtistCompare();
        Set<Song> songSet2 = new TreeSet<Song>(artistCompare);
        songSet2.addAll(songList);
        System.out.println("ȥ�ص�:\n" + songSet2);

//        Collections.sort(songList,artistCompare);
//        for(int i=0;i<songList.size();i++){
//            System.out.println("��"+(i+1)+"�׸���:"+songList.get(i));
//        }
    }

    //��ȡ�ļ� ��ȡ��������������뼯����
    public void getSongs() {
        //ͨ����ȡclassloader����ȡresource�ļ�
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

    //��������һ��������ӵ�������
    public void addSong(String line) {
        String[] songDatas = line.split("/");
        Song song = new Song();
        song.setTitle(songDatas[0]);
        song.setArtist(songDatas[1]);
        song.setRating(songDatas[2]);
        song.setBpm(songDatas[3]);
        //song[0] ����   song[1] ����
        this.songList.add(song);
    }

    //�ڲ���  ʵ���������
    class ArtistCompare implements Comparator<Song> {
        @Override
        public int compare(Song o1, Song o2) {//������������
            return o1.getArtist().compareTo(o2.getArtist());
        }
    }

    class TitleCompare implements Comparator<Song> {
        @Override
        public int compare(Song o1, Song o2) {//�Ը�������
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }

    public static void main(String[] args) {
        Jukebox4 jukebox4 = new Jukebox4();
        jukebox4.go();
    }
}
