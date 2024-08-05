# Pillars of OOP

## Main principles

### Encapsulation

**Encapsulation** is the mechanism of restricting direct access to some of an object's components and can prevent the
accidental modification of data. It is achieved by using private fields and providing public getter and setter methods.

```java
public class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }
}
```

Here, `name` and `age` are private fields. They are encapsulated within the `Person` class, and access to them is
provided through the public methods `getName`, `setName`, `getAge`, and `setAge`. This protects the integrity of the
data by allowing controlled access and modification.

### Abstraction

**Abstraction** is the concept of hiding the complex implementation details and showing only the essential features of
the object. This can be achieved using abstract classes and interfaces.

```java
abstract class Animal {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method
    public abstract void makeSound();
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}
```

In this example, `Animal` is an abstract class with an abstract method `makeSound`. The `Dog` and `Cat` classes
extend `Animal` and provide specific implementations of the `makeSound` method. This allows us to use the abstract
concept of `Animal` without worrying about the details of how each specific animal makes a sound.

### Inheritance

**Inheritance** is a mechanism wherein a new class is derived from an existing class. The derived class inherits the
fields and methods of the base class, allowing code reuse and the creation of hierarchical relationships.

```java
class Vehicle {
    protected String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public void honk() {
        System.out.println("Beep beep!");
    }
}

class Car extends Vehicle {
    private final String modelName;

    public Car(String brand, String modelName) {
        super(brand);
        this.modelName = modelName;
    }

    public void display() {
        System.out.println("Brand: " + brand + ", Model: " + modelName);
    }
}
```

In this example, `Car` inherits from `Vehicle`. It reuses the `brand` field and `honk` method from `Vehicle`, and adds
its own `modelName` field and `display` method. This demonstrates how inheritance allows the reuse of existing code and
the extension of functionalities.

### Polymorphism

**Polymorphism** allows objects of different classes to be treated as objects of a common super class. It is the ability
to present the same interface for differing underlying data types. Polymorphism is mainly achieved through method
overriding (run-time polymorphism) and method overloading (compile-time polymorphism).
**Method Overriding (Run-time Polymorphism):**

```java
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        myDog.makeSound(); // Outputs: Woof
        myCat.makeSound(); // Outputs: Meow
    }
}
```

In this example, `Dog` and `Cat` both override the `makeSound` method of the `Animal` class. The overridden method is
called based on the actual object type at runtime, demonstrating run-time polymorphism.
**Method Overloading (Compile-time Polymorphism):**

```java
class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        MathOperations math = new MathOperations();

        System.out.println(math.add(5, 3));         // 8
        System.out.println(math.add(5.5, 3.3));     // 8.8
        System.out.println(math.add(1, 2, 3));      // 6
    }
}
```

In this example, the `add` method is overloaded with different parameter lists. The appropriate method is selected at
compile time based on the argument types and count, demonstrating compile-time polymorphism.

## Inter-object relationships

| Is-a            | Has-a       |
|-----------------|-------------|
| Inheritance     | Composition |
| Implementration | Aggregation |

### Implementation

If class *Bird* is capable of singing (is *Sing-able*) and flying (is *Fly-able*) - we say that **Bird implements
Singable and Flyable**.
```java
interface Singable {
    void sing();
}

interface Flyable {
    void fly();
}

abstract class Bird implements Singable, Flyable {
    public abstract void sing();

    public abstract void fly();
}
```

*Bird* can `sing()`, `fly()` and do a lot of other things, as well as not everything that `sing()`s and/or `fly()`s is
a *Bird*.

### Inheritance

If class *Robin* is a particular kind of the class *Bird* - we say that **Robin inherits Bird**.

```java
class Robin extends Bird {
    @Override
    public void sing() {
        // sing
    }

    @Override
    public void fly() {
        // fly
    }
}
```

*Robin* can't be anything but a *Bird*, but not all *Bird*s are *Robin*s.
### Composition

If class *Robin* has a class *Personality* as a part of it (one makes no sense without another) we say that **Robin has
a Personality as a part of it's composition**
```java
class Personality {
    private String trait;
    // Constructor, getter, etc ..
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
    private String location;
    // Constructor, getter, etc ..
}

class Robin {
    private final Personality self;
    private Nest home;

    // Robin() {} - constructor by default is deliberately removed

    public Robin(Personality self) {
        this.self = self;
    }

    // Nest setter, getter, etc
}
```

# Patterns

Standard approaches to organize multiple class-to-class relationships into more complex structures are called
*Patterns*. Ones used in this project are:

## Singleton

Is a class with a unique, universally accessible object.

```java
// Single-thread version
public class Singleton {
    private static Singleton instance;
    // state fields

    private Singleton() {  // private constructor
        // init state
    }

    public static Singleton getInstance() {
        if (Singleton.instance == null) {  // lazy instantiation
            Singleton.instance = new Singleton();
        }
        return Singleton.instance;
    }
    // get/modify state methods
}
```

Worth noting, this pattern while seeming pretty has some
decent [drawbacks](https://stackoverflow.com/questions/137975/what-are-drawbacks-or-disadvantages-of-singleton-pattern?rq=1)
to consider.

## Factory

Is a class, which purpose is to provide a uniform way to create other objects, all of which derive from the same class
or implement same interface. *Factory* often is also a *Singleton* by it's nature.

```java
interface Flyable {
    void fly();
}

abstract class Aircraft implements Flyable {
    // state vars here
    public Aircraft(int id, String name, Coordinates coordinates) {/*...*/}
}

class Balloon extends Aircraft {
}

class Helicopter extends Aircraft {
}

class JetPlane extends Aircraft {
}

class AircraftFactory {
    private static int id = 0;

    public Flyable newAircraft(String type, String name, Coordinates coordinates) {
        return switch (type) {
            case "Balloon" -> new Balloon(AircraftFactory.id++, name, coordinates);
            case "Helicopter" -> new Helicopter(AircraftFactory.id++, name, coordinates);
            case "JetPlane" -> new JetPlane(AircraftFactory.id++, name, coordinates);
        };
    }
}

class Main {
    public static void main(String[] args) {
        AircraftFactory factory = new AircraftFactory();
        Flyable flyable = factory.newAircraft("Balloon", "B1", new Coordinates(/*...*/));
        flyable.fly();
    }
}
```

*One* factory `AircraftFactory` -> *one* interface `Flyable` / abstract class `Aircraft` -> *many*
implementations: `Balloon`, `Helicopter`, `JetPlane`.

## Observer

Is an interface / abstract class that defines methods, which will let implementing classes to *observe* the state of
another class **Observable** though it's lifecycle and receive notifications each time the **Observable**'s state is
changed.

```java
abstract class Observable {
    private final List<Observer> observers;
    // state variables - add in the child class

    public Observable() {
        this.observers = new ArrayList<>();
    }

    // abstract Observable doesn't know what kind of state derivative might have
    public abstract State getState();

    public void changeState(/* args */) {
        changeStateImpl(/* args */); // perform state change
        conditionChanged(); // notify observers
    }

    // each particular Observable mast have its own way to modify the state
    protected abstract void changeStateImpl();

    private void conditionChanged() { // notify all subscribed observers
        observers.forEach(Observer::updateConditions);
    }

    // each particular Observable may have some custom actions to do along with adding and removing observers
    public void register(Observer observer) {
        observer.add(observer);
        registerImpl(observer);
    }

    protected abstract void registerImpl(Observer observer);

    public void unregister(Observer observer) {/* remove from observers */}
}

class SubjectImpl extends Observable {
    // State state;

    public SubjectImpl() {/* init state */}

    @Override
    protected void changeStateImpl() {/* change state */}

    @Override
    protected void registerImpl(Observer observer) {
        System.out.println(observer + " is now subscribed");
    }

    @Override
    public State getState() {/* return state */}
}

abstract class Observer {
    protected Observable observable;

    public abstract void updateConditions();

    public void subscribe(Observable observable) {
        this.observable = observable;
        this.observable.register(this);
    }

    public void unSubscribe() {
        observable.unregister(this);
    }
}

class ObserverImpl1 extends Observer {
    // State myState
    @Override
    public void updateConditions() {
        State current = observable.getState();
        // update myState accordingly
    }
}

class ObserverImpl2 extends Observer {/* like ObserverImpl1 but a bit different */
}

class Main {
    public static void main(String[] args) {
        Observable subject = new SubjectImpl();
        Observer observer1 = new ObserverImpl1();
        Observer observer1a = new ObserverImpl1();
        Observer observer2 = new ObserverImpl2();

        observer1.subscribe(subject);
        observer1a.subscribe(subject);
        observer2.subscribe(subject);
        // observers know the state of the subject
        subject.changeState();
        // observers know the updated state of the subject
    }
}
```

Many `ObserverImplementation`s -> one `Observer` interface <--> one `Observable` interface ->
one `ObservableImplementation`

## Multiton

Is a *Factory* for *Singleton*s that implement the common interface.

```java
interface Loggable {
    void log(String message);
}

class ConsoleLogger implements Loggable {
    private static ConsoleLogger instance;
    private final boolean out;

    private ConsoleLogger(String outputStream) {
        instance = new ConsoleLogger();
        out = switch (outputStream) {
            case "out" -> true;
            case "err" -> false;
            // default -> throw Exception or whatever  
        };
    }

    public static ConsoleLogger getInstance(String arg) {/*...*/}

    void log(String message) {
        if (out)
            System.out.println(message);
        else
            System.err.println(message);
    }
}

class FileLogger implements Loggable {
    private static FileLogger instance;
    private final File file;

    private FileLogger(String outputStream) {
        instance = new FileLogger();
        // open or create file ..
    }

    public static FileLogger getInstance() {/* ... */}

    void log(String message) {
        file.write(message);
    }
}

// Multiton
final class LoggerFactory {
    private static final Map<String, Loggable> instances = new HashMap<>();

    public static void init(String logger, String arg) {
        if (!instances.containsKey(logger)) {
            instances.put(logger, switch (logger) {
                case "file" -> FileLogger.getInstance(arg);
                case "console" -> ConsoleLogger.getInstance(arg);
                // handle unsupported type
            });
        } else { /* handle reinitialisation */}
    }

    public static Loggable get(String type) {
        Loggable loggable = instances.get(type);
        if (loggable == null) { /* logger not initialised exception */ }
        return loggable;
    }
}

class Main {
    public static void main(String[] args) {
        LoggerFactory.init("console", "out");
        LoggerFactory.init("file", "file.txt");

        LoggerFactory.get("file").log("in file");
        LoggerFactory.get("console").log("on the screen");
    }
}
```

One static class `LoggerFactory` provides global and uniform access -> one interface `Loggable` -> implemented in many
ways by `FileLogger` and `ConsoleLogger`