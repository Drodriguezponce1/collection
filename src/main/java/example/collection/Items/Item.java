package example.collection.Items;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
    property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Music.class, name = "music"),
    @JsonSubTypes.Type(value = Books.class, name = "books"),
    @JsonSubTypes.Type(value = Media.class, name = "media")
})
public abstract class Item {
    public Item(){}
}
