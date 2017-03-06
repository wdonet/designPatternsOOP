package design.pattern.bridge

//Concrete implementor
class Sony implements TV {
    private int channel = 1
    private String brand = "Sony"

    @Override
    on() {
        println "Turn on Sony tv in channel $channel"
    }

    @Override
    off() {
        println "Turn off Sony tv"
    }

    @Override
    tuneChannel() {
        channel++
        if(channel > 3) {
            channel = 1
        }
        println "\tSony tv is inside channel $channel"
    }

    @Override
    getBrand() {
        return brand
    }
}
