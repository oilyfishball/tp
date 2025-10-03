package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.rank.Rank;
import seedu.address.model.tag.Tag;

/**
 * Represents a query object to find Person in the address book.
 * Guarantees: Field values are validated.
 * Remark: Details can be null and mutable.
 */
public class PersonQuery {

    // Identity fields
    private Optional<Name> name;
    private Optional<Phone> phone;
    private Optional<Email> email;

    // Data fields
    private Optional<Address> address;
    private final Optional<Set<Tag>> tags = Optional.of(new HashSet<>());
    private Optional<Rank> rank;

    /**
     * Represents empty query
     */
    public PersonQuery() {
        this(null, null, null, null, new HashSet<>(), null);
    }
    /**
     * Building person query at once
     */
    public PersonQuery(Name name, Phone phone, Email email, Address address, Set<Tag> tags, Rank rank) {
        this.name = Optional.ofNullable(name);
        this.phone = Optional.ofNullable(phone);
        this.email = Optional.ofNullable(email);
        this.address = Optional.ofNullable(address);
        this.tags.ifPresent(existingTags -> existingTags.addAll(tags));
        this.rank = Optional.ofNullable(rank);
    }

    public void setName(Name name) {
        this.name = Optional.of(name);
    }

    public void setPhone(Phone phone) {
        this.phone = Optional.of(phone);
    }

    public void setEmail(Email email) {
        this.email = Optional.of(email);
    }

    public void setAddress(Address address) {
        this.address = Optional.of(address);
    }

    public void setRank(Rank rank) {
        this.rank = Optional.of(rank);
    }

    public void setTags(Set<Tag> tags) {
        this.tags.ifPresent(existingTags -> existingTags.addAll(tags));
    }

    /**
     * A predicate function of type {@code Predicate<Person>} to filter persons in a collection (such as lists).
     * This function checks whether {@code Person} object follows the query given in {@code PersonQuery} object.
     * {@code Person} must satisfy all fields (e.g. {@code this.name}, {#code this.email}, ...)
     * in order for this function to return true.
     * <br/>
     * If {@code this.[FIELD]} is Nullable, {@code isCorrect[FIELD]} must always return true.
     *
     * @param person {@code Person} object to check
     * @return true if the person corresponds to the given query addressed above.
     */
    public boolean filter(Person person) {
        boolean isCorrectName = this.name.filter(name -> !person.getName().equals(name)).isEmpty();
        boolean isCorrectPhone = this.phone.filter(phone -> !person.getPhone().equals(phone)).isEmpty();
        boolean isCorrectAddress = this.address.filter(address -> !person.getAddress().equals(address)).isEmpty();
        boolean isCorrectEmail = this.email.filter(email -> !person.getEmail().equals(email)).isEmpty();
        boolean isCorrectRank = this.rank.filter(rank -> !person.getRank().equals(rank)).isEmpty();
        boolean isCorrectTags = this.tags.filter(tags -> !person.getTags().containsAll(tags)).isEmpty();
        return isCorrectName && isCorrectPhone && isCorrectAddress && isCorrectEmail && isCorrectRank
                && isCorrectTags;
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PersonQuery)) {
            return false;
        }

        PersonQuery otherPerson = (PersonQuery) other;
        return name.equals(otherPerson.name)
                && phone.equals(otherPerson.phone)
                && email.equals(otherPerson.email)
                && address.equals(otherPerson.address)
                && tags.equals(otherPerson.tags)
                && rank.equals(otherPerson.rank);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, tags, rank);
    }
}
