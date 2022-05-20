package fi.mongo.training;

import com.google.gson.*;
import com.google.gson.reflect.*;
import com.google.gson.stream.*;
import java.io.IOException;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.processing.Generated;

/**
 * A {@code TypeAdapterFactory} that handles all of the immutable types generated under {@code Tree}.
 * @see ImmutableTree
 */
@SuppressWarnings({"all", "MethodCanBeStatic"})
@ParametersAreNonnullByDefault
@Generated("org.immutables.processor.ProxyProcessor")
@org.immutables.value.Generated(from = "fi.mongo.training", generator = "Gsons")
public final class GsonAdaptersTree implements TypeAdapterFactory {
  @SuppressWarnings({"unchecked", "raw"}) // safe unchecked, types are verified in runtime
  @Override
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
    if (TreeTypeAdapter.adapts(type)) {
      return (TypeAdapter<T>) new TreeTypeAdapter(gson);
    }
    return null;
  }

  @Override
  public String toString() {
    return "GsonAdaptersTree(Tree)";
  }

  @org.immutables.value.Generated(from = "Tree", generator = "Gsons")
  @SuppressWarnings({"unchecked", "raw"}) // safe unchecked, types are verified in runtime
  private static class TreeTypeAdapter extends TypeAdapter<Tree> {
    public final TreeSpecies speciesTypeSample = null;
    private final TypeAdapter<TreeSpecies> speciesTypeAdapter;

    TreeTypeAdapter(Gson gson) {
      this.speciesTypeAdapter = gson.getAdapter( TreeSpecies.class);
    } 

    static boolean adapts(TypeToken<?> type) {
      return Tree.class == type.getRawType()
          || ImmutableTree.class == type.getRawType();
    }

    @Override
    public void write(JsonWriter out, Tree value) throws IOException {
      if (value == null) {
        out.nullValue();
      } else {
        writeTree(out, value);
      }
    }

    @Override
    public Tree read(JsonReader in) throws IOException {
      return readTree(in);
    }

    private void writeTree(JsonWriter out, Tree instance)
        throws IOException {
      out.beginObject();
      out.name("_id");
      out.value(instance.id());
      out.name("height");
      out.value(instance.height());
      out.name("species");
      speciesTypeAdapter.write(out, instance.species());
      out.endObject();
    }

    private  Tree readTree(JsonReader in)
        throws IOException {
      if (in.peek() == JsonToken.NULL) {
        in.nextNull();
        return null;
      }
      ImmutableTree.Builder builder = ImmutableTree.builder();
      in.beginObject();
      while (in.hasNext()) {
        eachAttribute(in, builder);
      }
      in.endObject();
      return builder.build();
    }

    private void eachAttribute(JsonReader in, ImmutableTree.Builder builder)
        throws IOException {
      String attributeName = in.nextName();
      switch (attributeName.charAt(0)) {
      case '_':
        if ("_id".equals(attributeName)) {
          readInId(in, builder);
          return;
        }
        break;
      case 'h':
        if ("height".equals(attributeName)) {
          readInHeight(in, builder);
          return;
        }
        break;
      case 's':
        if ("species".equals(attributeName)) {
          readInSpecies(in, builder);
          return;
        }
        break;
      default:
      }
      in.skipValue();
    }

    private void readInId(JsonReader in, ImmutableTree.Builder builder)
        throws IOException {
      builder.id(in.nextLong());
    }

    private void readInHeight(JsonReader in, ImmutableTree.Builder builder)
        throws IOException {
      builder.height(in.nextInt());
    }

    private void readInSpecies(JsonReader in, ImmutableTree.Builder builder)
        throws IOException {
      TreeSpecies value = speciesTypeAdapter.read(in);
      builder.species(value);
    }
  }
}
