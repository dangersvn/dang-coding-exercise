package coding.exercise.controller;

import coding.exercise.dto.ResponseDTO;
import coding.exercise.errorhandling.BreedsIOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.*;

@RestController
@RequestMapping("api/breeds")
public class BreedController {

    @Autowired
    ObjectMapper mapper;

    @RequestMapping("list/all")
    public ResponseEntity<ResponseDTO> getAllBreeds() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("apidata.json");
        if(inputStream == null)  {
            throw new BreedsIOException("Empty json file resource");
        }
        SortedMap<String, List<String>> map = new TreeMap<>();
        ResponseDTO dto = new ResponseDTO();
        map = mapper.readValue(inputStream, SortedMap.class);
        dto.setMessage(map);
        dto.setStatus("success");
        return  ResponseEntity.ok(dto);
    }
}
