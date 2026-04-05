import java.util.List;
public class Zoo<T extends Animal> {

    public void transferAnimals(List<? extends T> source, List<? super T> destination) {
        for (T animal : source) {
            destination.add(animal);
        }
        source.clear(); // HUSWEL HOOSOLJ BOLNO
    }
}