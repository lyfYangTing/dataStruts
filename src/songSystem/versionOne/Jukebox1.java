package songSystem.versionOne;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by 18435 on 2017/9/27.
 */
public class Jukebox1 {

    private ArrayList<String> songList = new ArrayList<String>();//仅将歌名cunzau数组中

    //列出所有歌名
    public void go(){
        getSongs();
        for(int i=0;i<songList.size();i++){
            System.out.println("第"+(i+1)+"首歌是:"+songList.get(i));
        }
        Collections.sort(songList);//排序
        for(int i=0;i<songList.size();i++){
            System.out.println("第"+(i+1)+"首歌是:"+songList.get(i));
        }
    }

    //读取文件 获取歌名，并将其放入集合中
    public void getSongs(){
        //通过获取classloader来获取resource文件
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

    //将读出的一行数据添加到集合中
    public void addSong(String line){
        String[] song = line.split("/");
        //song[0] 歌名   song[1] 歌星
        this.songList.add(song[0]);
    }
}
