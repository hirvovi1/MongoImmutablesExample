package fi.mongo.training;

import com.google.gson.*;
import com.google.gson.reflect.*;
import com.google.gson.stream.*;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.processing.Generated;

/**
 * A {@code TypeAdapterFactory} that handles all of the immutable types generated under {@code Item}.
 * @see ImmutableItem
 */
@SuppressWarnings({"all", "MethodCanBeStatic"})
@ParametersAreNonnullByDefault
@Generated("org.immutables.processor.ProxyProcessor")
@org.immutables.value.Generated(from = "fi.mongo.training", generator = "Gsons")
public final class GsonAdaptersItem implements TypeAdapterFactory {
  @SuppressWarnings({"unchecked", "raw"}) // safe unchecked, types are verified in runtime
  @Override
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
    if (ItemTypeAdapter.adapts(type)) {
      return (TypeAdapter<T>) new ItemTypeAdapter(gson);
    }
    return null;
  }

  @Override
  public String toString() {
    return "GsonAdaptersItem(Item)";
  }

  @org.immutables.value.Generated(from = "Item", generator = "Gsons")
  @SuppressWarnings({"unchecked", "raw"}) // safe unchecked, types are verified in runtime
  private static class ItemTypeAdapter extends TypeAdapter<Item> {
    public final Integer valuesTypeSample = null;
    private final TypeAdapter<Integer> valuesTypeAdapter;

    ItemTypeAdapter(Gson gson) {
      this.valuesTypeAdapter = gson.getAdapter( Integer.class);
    } 

    static boolean adapts(TypeToken<?> type) {
      return Item.class == type.getRawType()
          || ImmutableItem.class == type.getRawType();
    }

    @Override
    public void write(JsonWriter out, Item value) throws IOException {
      if (value == null) {
        out.nullValue();
      } else {
        writeItem(out, value);
      }
    }

    @Override
    public Item read(JsonReader in) throws IOException {
      return readItem(in);
    }

    private void writeItem(JsonWriter out, Item instance)
        throws IOException {
      out.beginObject();
      out.name("_id");
      out.value(instance.id());
      out.name("name");
      out.value(instance.name());
      Set<Integer> valuesElements = instance.values();
      out.name("values");
      out.beginArray();
      for (Integer e : valuesElements) {
        valuesTypeAdapter.write(out, e);
      }
      out.endArray();
      Optional<String> commentOptional = instance.comment();
      if (commentOptional.isPresent()) {
        out.name("comment");
        String commentValue = commentOptional.get();
        out.value(commentValue);
      } else if (out.getSerializeNulls()) {
        out.name("comment");
        out.nullValue();
      }
      out.endObject();
    }

    private  Item readItem(JsonReader in)
        throws IOException {
      if (in.peek() == JsonToken.NULL) {
        in.nextNull();
        return null;
      }
      ImmutableItem.Builder builder = ImmutableItem.builder();
      in.beginObject();
      while (in.hasNext()) {
        eachAttribute(in, builder);
      }
      in.endObject();
      return builder.build();
    }

    private void eachAttribute(JsonReader in, ImmutableItem.Builder builder)
        throws IOException {
      String attributeName = in.nextName();
      switch (attributeName.charAt(0)) {
      case '_':
        if ("_id".equals(attributeName)) {
          readInId(in, builder);
          return;
        }
        break;
      case 'n':
        if ("name".equals(attributeName)) {
          readInName(in, builder);
          return;
        }
        break;
      case 'v':
        if ("values".equals(attributeName)) {
          readInValues(in, builder);
          return;
        }
        break;
      case 'c':
        if ("comment".equals(attributeName)) {
          readInComment(in, builder);
          return;
        }
        break;
      default:
      }
      in.skipValue();
    }

    private void readInId(JsonReader in, ImmutableItem.Builder builder)
        throws IOException {
      builder.id(in.nextLong());
    }

    private void readInName(JsonReader in, ImmutableItem.Builder builder)
        throws IOException {
      builder.name(in.nextString());
    }

    private void readInValues(JsonReader in, ImmutableItem.Builder builder)
        throws IOException {
      if (in.peek() == JsonToken.BEGIN_ARRAY) {
        in.beginArray();
        while(in.hasNext()) {
          builder.addValues(in.nextInt());
        }
        in.endArray();
      } else if (in.peek() == JsonToken.NULL) {
        in.nextNull();
      } else {
        builder.addValues(in.nextInt());
      }
    }

    private void readInComment(JsonReader in, ImmutableItem.Builder builder)
        throws IOException {
      if (in.peek() == JsonToken.NULL) {
        in.nextNull();
      } else {
        builder.comment(in.nextString());
      }
    }
  }
}
