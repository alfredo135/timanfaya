package com.digital.demo.dto;

import lombok.Data;
import java.util.List;

@Data
public class TransformedData {
    private int totalUsers;
    private List<String> userNames;
}
