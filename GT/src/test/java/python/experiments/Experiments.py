class Experiments:
    age = 15
    name = "Hello"

    def __init__(self):
        self.phone = 937528273

def method(id):
    exp = Experiments()
    x = lambda y : executeQuery(y)
    exp.name = exp.name + "test"
    exp.age = exp.age + 1
    exp.age = 2 * exp.age
    exp.age = exp.age - 10
    exp.age /= 2
    exp.age %= 2
    exp.age *= 10
    exp.age += 1
    exp.age -= 1

    numb = exp.age

    if(numb < 1):
        numb = 0
    else:
        x(exp.name + id)

    if(exp.age >= 10):
       executeQuery(exp)

    if(exp.age != 10):
        exp.name = "!="
    elif(exp.age == 5):
        exp.name = "=="
    elif(exp.age <= 10):
        exp.name = id
    else:
        exp.age = 100

    if(exp.age < 100):
        executeQuery(exp)
        id = sanitize(id)
        x(id)

    x(exp.name)
    x(exp)

    methodV2(exp.name, exp.age)


def methodV2(string, num):
    if(num >= 10):
        executeQuery(string)
    


