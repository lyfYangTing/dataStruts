package songSystem.versiontwo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by 18435 on 2017/9/27.
 */
public class Jukebox2 {
    private ArrayList<Song> songList = new ArrayList<Song>();//��������cunzau������

    //�г����и���
    public void go(){
        getSongs();
        for(int i=0;i<songList.size();i++){
            System.out.println("��"+(i+1)+"�׸���:"+songList.get(i));
        }
        Collections.sort(songList);
        for(int i=0;i<songList.size();i++){
            System.out.println("��"+(i+1)+"�׸���:"+songList.get(i));
        }
    }

    //��ȡ�ļ� ��ȡ��������������뼯����
    public void getSongs(){
        //ͨ����ȡclassloader����ȡresource�ļ�
        InputStream is = Jukebox2.class.getClassLoader().getResourceAsStream("SongList.txt");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while((line=reader.readLine())!=null){
                addSong(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //��������һ��������ӵ�������
    public void addSong(String line){
        String[] songDatas = line.split("/");
        Song song = new Song();
        song.setTitle(songDatas[0]);
        song.setArtist(songDatas[1]);
        song.setRating(songDatas[2]);
        song.setBpm(songDatas[3]);
        //song[0] ����   song[1] ����
        this.songList.add(song);
    }
}
