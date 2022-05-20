package fi.mongo.training;

import com.google.gson.*;
import com.google.gson.reflect.*;
import com.google.gson.stream.*;
import java.io.IOException;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.processing.Generated;
import org.bson.types.ObjectId;

/**
 * A {@code TypeAdapterFactory} that handles all of the immutable types generated under {@code Flower}.
 * @see ImmutableFlower
 */
@SuppressWarnings({"all", "MethodCanBeStatic"})
@ParametersAreNonnullByDefault
@Generated("org.immutables.processor.ProxyProcessor")
@org.immutables.value.Generated(from = "fi.mongo.training", generator = "Gsons")
public final class GsonAdaptersFlower implements TypeAdapterFactory {
  @SuppressWarnings({"unchecked", "raw"}) // safe unchecked, types are verified in runtime
  @Override
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
    if (FlowerTypeAdapter.adapts(type)) {
      return (TypeAdapter<T>) new FlowerTypeAdapter(gson);
    }
    return null;
  }

  @Override
  public String toString() {
    return "GsonAdaptersFlower(Flower)";
  }

  @org.immutables.value.Generated(from = "Flower", generator = "Gsons")
  @SuppressWarnings({"unchecked", "raw"}) // safe unchecked, types are verified in runtime
  private static class FlowerTypeAdapter extends TypeAdapter<Flower> {
    public final ObjectId idTypeSample = null;
    public final Boolean isBloomingTypeSample = null;
    public final Float heightTypeSample = null;
    private final TypeAdapter<ObjectId> idTypeAdapter;
    private final TypeAdapter<Boolean> isBloomingTypeAdapter;
    private final TypeAdapter<Float> heightTypeAdapter;

    FlowerTypeAdapter(Gson gson) {
      this.idTypeAdapter = gson.getAdapter( ObjectId.class);
      this.isBloomingTypeAdapter = gson.getAdapter( Boolean.class);
      this.heightTypeAdapter = gson.getAdapter( Float.class);
    } 

    static boolean adapts(TypeToken<?> type) {
      return Flower.class == type.getRawType()
          || ImmutableFlower.class == type.getRawType();
    }

    @Override
    public void write(JsonWriter out, Flower value) throws IOException {
      if (value == null) {
        out.nullValue();
      } else {
        writeFlower(out, value);
      }
    }

    @Override
    public Flower read(JsonReader in) throws IOException {
      return readFlower(in);
    }

    private void writeFlower(JsonWriter out, Flower instance)
        throws IOException {
      out.beginObject();
      out.name("_id");
      idTypeAdapter.write(out, instance.getId());
      out.name("name");
      out.value(instance.getName());
      out.name("isBlooming");
      isBloomingTypeAdapter.write(out, instance.getIsBlooming());
      out.name("height");
      heightTypeAdapter.write(out, instance.getHeight());
      List<String> colorsElements = instance.getColors();
      out.name("colors");
      out.beginArray();
      for (String e : colorsElements) {
        out.value(e);
      }
      out.endArray();
      out.endObject();
    }

    private  Flower readFlower(JsonReader in)
        throws IOException {
      if (in.peek() == JsonToken.NULL) {
        in.nextNull();
        return null;
      }
      ImmutableFlower.Builder builder = ImmutableFlower.builder();
      in.beginObject();
      while (in.hasNext()) {
        eachAttribute(in, builder);
      }
      in.endObject();
      return builder.build();
    }

    private void eachAttribute(JsonReader in, ImmutableFlower.Builder builder)
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
      case 'i':
        if ("isBlooming".equals(attributeName)) {
          readInIsBlooming(in, builder);
          return;
        }
        break;
      case 'h':
        if ("height".equals(attributeName)) {
          readInHeight(in, builder);
          return;
        }
        break;
      case 'c':
        if ("colors".equals(attributeName)) {
          readInColors(in, builder);
          return;
        }
        break;
      default:
      }
      in.skipValue();
    }

    private void readInId(JsonReader in, ImmutableFlower.Builder builder)
        throws IOException {
      ObjectId value = idTypeAdapter.read(in);
      builder.id(value);
    }

    private void readInName(JsonReader in, ImmutableFlower.Builder builder)
        throws IOException {
      builder.name(in.nextString());
    }

    private void readInIsBlooming(JsonReader in, ImmutableFlower.Builder builder)
        throws IOException {
      Boolean value = isBloomingTypeAdapter.read(in);
      builder.isBlooming(value);
    }

    private void readInHeight(JsonReader in, ImmutableFlower.Builder builder)
        throws IOException {
      Float value = heightTypeAdapter.read(in);
      builder.height(value);
    }

    private void readInColors(JsonReader in, ImmutableFlower.Builder builder)
        throws IOException {
      if (in.peek() == JsonToken.BEGIN_ARRAY) {
        in.beginArray();
        while(in.hasNext()) {
          builder.addColors(in.nextString());
        }
        in.endArray();
      } else if (in.peek() == JsonToken.NULL) {
        in.nextNull();
      } else {
        builder.addColors(in.nextString());
      }
    }
  }
}
