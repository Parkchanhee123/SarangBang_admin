package edu.sm.app.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "User")
public class CustDto {

    @Id
    @Field("_id")
    private String id;  // MongoDB의 "_id"와 매핑됨

    @Field("user_uuid")
    private String userUuid;

    @Field("user_family_email")
    private String userFamilyEmail;

    @Field("user_date")
    private String userDate;
}
