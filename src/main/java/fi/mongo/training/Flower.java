package fi.mongo.training;

import org.bson.types.ObjectId;
import org.immutables.mongo.Mongo;
import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@Mongo.Repository
public abstract class Flower {
    @Mongo.Id
    public abstract ObjectId getId();

    public abstract String getName();

    public abstract Boolean getIsBlooming();

    public abstract Float getHeight();

    public abstract List<String> getColors();
}
