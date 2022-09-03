package ro.sda.javaro35.finalProject.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SearchFormDto {
    List<Long> ingredientsListIds =new ArrayList<>();
}
