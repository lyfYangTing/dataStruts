package songSystem.versionOne;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by 18435 on 2017/9/27.
 */
public class Jukebox1 {

    private ArrayList<String> songList = new ArrayList<String>();//��������cunzau������

    //�г����и���
    public void go(){
        getSongs();
        for(int i=0;i<songList.size();i++){
            System.out.println("��"+(i+1)+"�׸���:"+songList.get(i));
        }
        Collections.sort(songList);//����
        for(int i=0;i<songList.size();i++){
            System.out.println("��"+(i+1)+"�׸���:"+songList.get(i));
        }
    }

    //��ȡ�ļ� ��ȡ��������������뼯����
    public void getSongs(){
        //ͨ����ȡclassloader����ȡresource�ļ�
        InputStream is = Jukebox1.class.getClassLoader().getResourceAsStream("SongList.txt");
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
        String[] song = line.split("/");
        //song[0] ����   song[1] ����
        this.songList.add(song[0]);
    }
}
