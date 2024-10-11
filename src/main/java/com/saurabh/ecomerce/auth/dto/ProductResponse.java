package com.saurabh.ecomerce.auth.dto;


import com.saurabh.ecomerce.auth.models.BaseModel;
import lombok.*;


@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse  {
    public String id;
    public String title;
    public String description;
    public String price;
    public String image;
    public String category;
}
