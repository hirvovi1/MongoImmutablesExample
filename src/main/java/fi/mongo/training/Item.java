package fi.mongo.training;

import org.immutables.mongo.Mongo;
import org.immutables.value.Value;

import java.util.Optional;
import java.util.Set;

// Define repository for collection "items".
@Value.Immutable
@Mongo.Repository
public abstract class Item {
    @Mongo.Id
    public abstract long id();
    public abstract String name();
    public abstract Set<Integer> values();
    public abstract Optional<String> comment();
}
