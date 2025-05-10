# Pixel Sand Simulation

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

![Swing](https://img.shields.io/badge/GUI-Java_Swing-007396)

An interactive Java Swing particle system with gravity and color-changing effects


## ✨ Features
Interactive sand physics with gravity and collision

Multi-color particles with automatic color cycling

Mouse drawing - click and drag to create particles

# Keyboard controls:

SPACE - Clear all particles

S - Toggle color animation

Optimized rendering at 60 FPS

# 🚀 How to Run
javac *.java && java Main

# 🕹️ Controls
Key	Action
Mouse Drag	Draw particles
SPACE	Reset simulation
S	Toggle color cycling
# 🧠 Physics Implementation
```
// Gravity and collision logic
if (canFall) {
    point.get(i).y += HEIGHT; // Fall down
} else {
    // Random sideways movement
    point.get(i).x += WIDTH * (randomBoolean() ? 1 : -1);
}
```

🎨 Color System
Predefined color palette with automatic cycling:
```
Color[] colors = {
    Color.RED, Color.BLUE, 
    Color.YELLOW, Color.CYAN
};
```
📂 Suggested GitHub Description
"Interactive pixel sand simulation with realistic gravity and colorful particles. Features mouse drawing, keyboard controls, and smooth physics - perfect for learning Java Swing and simple particle systems!"

® Created by Hussam Alibrahim

