package fi.mongo.training;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.bson.types.ObjectId;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Flower}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableFlower.builder()}.
 */
@Generated(from = "Flower", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutableFlower extends Flower {
  private final ObjectId id;
  private final String name;
  private final Boolean isBlooming;
  private final Float height;
  private final ImmutableList<String> colors;

  private ImmutableFlower(
      ObjectId id,
      String name,
      Boolean isBlooming,
      Float height,
      ImmutableList<String> colors) {
    this.id = id;
    this.name = name;
    this.isBlooming = isBlooming;
    this.height = height;
    this.colors = colors;
  }

  /**
   * @return The value of the {@code id} attribute
   */
  @Override
  public ObjectId getId() {
    return id;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * @return The value of the {@code isBlooming} attribute
   */
  @Override
  public Boolean getIsBlooming() {
    return isBlooming;
  }

  /**
   * @return The value of the {@code height} attribute
   */
  @Override
  public Float getHeight() {
    return height;
  }

  /**
   * @return The value of the {@code colors} attribute
   */
  @Override
  public ImmutableList<String> getColors() {
    return colors;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Flower#getId() id} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for id
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFlower withId(ObjectId value) {
    if (this.id == value) return this;
    ObjectId newValue = Objects.requireNonNull(value, "id");
    return new ImmutableFlower(newValue, this.name, this.isBlooming, this.height, this.colors);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Flower#getName() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFlower withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutableFlower(this.id, newValue, this.isBlooming, this.height, this.colors);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Flower#getIsBlooming() isBlooming} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for isBlooming
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFlower withIsBlooming(Boolean value) {
    Boolean newValue = Objects.requireNonNull(value, "isBlooming");
    if (this.isBlooming.equals(newValue)) return this;
    return new ImmutableFlower(this.id, this.name, newValue, this.height, this.colors);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Flower#getHeight() height} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for height
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFlower withHeight(Float value) {
    Float newValue = Objects.requireNonNull(value, "height");
    if (this.height.equals(newValue)) return this;
    return new ImmutableFlower(this.id, this.name, this.isBlooming, newValue, this.colors);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Flower#getColors() colors}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableFlower withColors(String... elements) {
    ImmutableList<String> newValue = ImmutableList.copyOf(elements);
    return new ImmutableFlower(this.id, this.name, this.isBlooming, this.height, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Flower#getColors() colors}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of colors elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableFlower withColors(Iterable<String> elements) {
    if (this.colors == elements) return this;
    ImmutableList<String> newValue = ImmutableList.copyOf(elements);
    return new ImmutableFlower(this.id, this.name, this.isBlooming, this.height, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableFlower} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableFlower
        && equalTo((ImmutableFlower) another);
  }

  private boolean equalTo(ImmutableFlower another) {
    return id.equals(another.id)
        && name.equals(another.name)
        && isBlooming.equals(another.isBlooming)
        && height.equals(another.height)
        && colors.equals(another.colors);
  }

  /**
   * Computes a hash code from attributes: {@code id}, {@code name}, {@code isBlooming}, {@code height}, {@code colors}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + id.hashCode();
    h += (h << 5) + name.hashCode();
    h += (h << 5) + isBlooming.hashCode();
    h += (h << 5) + height.hashCode();
    h += (h << 5) + colors.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Flower} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Flower")
        .omitNullValues()
        .add("id", id)
        .add("name", name)
        .add("isBlooming", isBlooming)
        .add("height", height)
        .add("colors", colors)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link Flower} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Flower instance
   */
  public static ImmutableFlower copyOf(Flower instance) {
    if (instance instanceof ImmutableFlower) {
      return (ImmutableFlower) instance;
    }
    return ImmutableFlower.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableFlower ImmutableFlower}.
   * <pre>
   * ImmutableFlower.builder()
   *    .id(org.bson.types.ObjectId) // required {@link Flower#getId() id}
   *    .name(String) // required {@link Flower#getName() name}
   *    .isBlooming(Boolean) // required {@link Flower#getIsBlooming() isBlooming}
   *    .height(Float) // required {@link Flower#getHeight() height}
   *    .addColors|addAllColors(String) // {@link Flower#getColors() colors} elements
   *    .build();
   * </pre>
   * @return A new ImmutableFlower builder
   */
  public static ImmutableFlower.Builder builder() {
    return new ImmutableFlower.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableFlower ImmutableFlower}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Flower", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ID = 0x1L;
    private static final long INIT_BIT_NAME = 0x2L;
    private static final long INIT_BIT_IS_BLOOMING = 0x4L;
    private static final long INIT_BIT_HEIGHT = 0x8L;
    private long initBits = 0xfL;

    private @Nullable ObjectId id;
    private @Nullable String name;
    private @Nullable Boolean isBlooming;
    private @Nullable Float height;
    private ImmutableList.Builder<String> colors = ImmutableList.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Flower} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Flower instance) {
      Objects.requireNonNull(instance, "instance");
      id(instance.getId());
      name(instance.getName());
      isBlooming(instance.getIsBlooming());
      height(instance.getHeight());
      addAllColors(instance.getColors());
      return this;
    }

    /**
     * Initializes the value for the {@link Flower#getId() id} attribute.
     * @param id The value for id 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder id(ObjectId id) {
      this.id = Objects.requireNonNull(id, "id");
      initBits &= ~INIT_BIT_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link Flower#getName() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link Flower#getIsBlooming() isBlooming} attribute.
     * @param isBlooming The value for isBlooming 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isBlooming(Boolean isBlooming) {
      this.isBlooming = Objects.requireNonNull(isBlooming, "isBlooming");
      initBits &= ~INIT_BIT_IS_BLOOMING;
      return this;
    }

    /**
     * Initializes the value for the {@link Flower#getHeight() height} attribute.
     * @param height The value for height 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder height(Float height) {
      this.height = Objects.requireNonNull(height, "height");
      initBits &= ~INIT_BIT_HEIGHT;
      return this;
    }

    /**
     * Adds one element to {@link Flower#getColors() colors} list.
     * @param element A colors element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addColors(String element) {
      this.colors.add(element);
      return this;
    }

    /**
     * Adds elements to {@link Flower#getColors() colors} list.
     * @param elements An array of colors elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addColors(String... elements) {
      this.colors.add(elements);
      return this;
    }


    /**
     * Sets or replaces all elements for {@link Flower#getColors() colors} list.
     * @param elements An iterable of colors elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder colors(Iterable<String> elements) {
      this.colors = ImmutableList.builder();
      return addAllColors(elements);
    }

    /**
     * Adds elements to {@link Flower#getColors() colors} list.
     * @param elements An iterable of colors elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllColors(Iterable<String> elements) {
      this.colors.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutableFlower ImmutableFlower}.
     * @return An immutable instance of Flower
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableFlower build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableFlower(id, name, isBlooming, height, colors.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_IS_BLOOMING) != 0) attributes.add("isBlooming");
      if ((initBits & INIT_BIT_HEIGHT) != 0) attributes.add("height");
      return "Cannot build Flower, some of required attributes are not set " + attributes;
    }
  }
}
