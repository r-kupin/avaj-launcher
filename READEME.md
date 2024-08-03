# Pillars of OOP

## Inter-object relationships

| Is-a            | Has-a       |
|-----------------|-------------|
| Inheritance     | Composition |
| Implementration | Aggregation |

### Inheritance

If class *Robin* is a particular kind of the class *Bird* - we say that **Robin inherits Bird**.

```java
abstract class Bird {
}

class Robin extends Bird {
}
```

*Robin* can't be anything but a *Bird*, but not all *Bird*s are *Robin*s.

### Implementation

If class *Robin* is capable of singing (is *Sing-able*) and flying (is *Fly-able*) - we say that **Robin implements
Singable and Flyable**.

```java
interface Singable {
    void sing();
}

interface Flyable {
    void fly();
}

class Robin implements Singable, Flyable {
    @Override
    void sing() {
    }

    @Override
    void fly() {
    }
}
```

*Robin* can `sing()`, `fly()` and do a lot of other things, as well as not everything that `sing()`s and/or `fly()`s is
a *Robin*.

### Composition

If class *Robin* has a class *Personality* as a part of it (one makes no sense without another) we say that **Robin has
a Personality as a part of it's composition**

```java
class Personality {
}

class Robin {
    private final Personality self;

    // Robin() {} - constructor by default is deliberately removed

    public Robin(Personality self) {
        this.self = self;
    }
}
```

### Aggregation

If class *Robin* has a class *Nest* in it's possession (each one can exist independently) we say that **Robin aggregates
a Nest**

```java
class Nest {
}

class Personality {
}

class Robin {
    private final Personality self;
    private Nest home;

    // Robin() {} - constructor by default is deliberately removed

    public Robin(Personality self) {
        this.self = self;
    }

    public Robin(Personality self, Nest nest) {
        this.self = self;
        this.home = nest;
    }

    public setHome(Nest nest) {
        this.home = nest;
    }

    public abandonHome() {
        this.home = null;
    }
}
```

## Patterns

Standard approaches to organize multiple class-to-class relationships into more complex structures are called
*Patterns*. Ones used in this project are:

### Basic

#### Singleton

#### Factory

#### Observer

### Complex patterns

#### Multitone
