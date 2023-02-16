package model;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotesMapperJSON implements NotesMapper{

    @Override
    public String map(List<Note> list) {
        List<Map> result = new ArrayList<>();
        Gson gson = new Gson();

        for (Note note : list){
            Map map = new HashMap<>();
            map.put("id", note.getId());
            map.put("head", note.getHead());
            map.put("text", note.getText());
            result.add(map);
        }

        return gson.toJson(result);
    }

    @Override
    public List<Note> map(String text) throws Exception{
        Gson gson = new Gson();
        List<Note> list = new ArrayList<>();

        List<Map> listGSON = null;

        try {
            listGSON = gson.fromJson(text, ArrayList.class);

            if (listGSON == null){
                return list;
            }

            for (Map map : listGSON){
                String id = (String) map.get("id");
                String head = (String) map.get("head");
                String textNote = (String) map.get("text");

                Note note = new Note(id, head, textNote);
                list.add(note);
            }
        }catch (Exception e){
            throw new Exception("Файл некорректный");
        }

        return list;
    }
}
