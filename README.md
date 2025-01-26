# Overview

I created a limited game app that uses a drawing board. I learned a lot about how canvas objects work, how to track a moving mouse and use that to call a method.

I have limited experience working with GUI's so I thought a painting app would be a interesting way to interact with a new type of objects I hadn't previously worked with and I wanted to learn java as well.

{Provide a link to your YouTube demonstration. It should be a 4-5 minute demo of the software running and a walkthrough of the code. Focus should be on sharing what you learned about the language syntax.}

[Software Demo Video](http://youtube.link.goes.here)

# Development Environment

I used JDK 21, the most current long term edition.

{Describe the programming language that you used and any libraries.}
- [Official Java Development Kit](https://docs.oracle.com/en/java/javase/index.html)

# Libraries Used

## Java AWT (Abstract Window Toolkit)
- java.awt.*: Provides classes for creating user interfaces and for painting graphics and images. This includes components like Frame, Panel, and Canvas.
- java.awt.event.*: Contains interfaces and classes for handling different types of events fired by AWT components, such as mouse and keyboard events.
- java.awt.geom.*: Offers classes for defining and performing operations on objects related to two-dimensional geometry, such as Ellipse2D and Rectangle2D.
- java.awt.image.*: Provides classes for creating and modifying images, including BufferedImage for handling image data.
- java.awt.Color: Represents colors using the RGB color model, allowing for the specification and manipulation of colors.
- java.awt.Graphics2D: Extends the Graphics class to provide more sophisticated control over geometry, coordinate transformations, color management, and text layout.
- java.awt.RenderingHints: Allows the specification of preferences for the rendering algorithms used by Graphics2D.
- java.awt.AlphaComposite: Provides a way to compose a drawing operation with an alpha value, enabling transparency effects.
## Java Swing
- javax.swing.*: Contains a set of 'lightweight' components that work consistently across all platforms. This includes components like JFrame, JPanel, JMenuBar, and JColorChooser.
- javax.swing.event.*: Provides interfaces and classes for handling events fired by Swing components, such as action events from buttons and menu items.
## Java IO
- java.io.*: Offers classes for system input and output through data streams, serialization, and the file system. This includes classes like File and IOException.
## Java Util
- java.util.*: Contains the collections framework, legacy collection classes, event model, date and time facilities, internationalization, and miscellaneous utility classes. This includes ArrayList for managing collections of shapes and colors.
- java.util.Stack: Represents a last-in-first-out (LIFO) stack of objects, used for implementing undo and redo functionality.
## Java ImageIO
- javax.imageio.ImageIO: A class for reading and writing images in various formats. This is used for saving and loading images to and from files.

# Useful Websites

- [W3 Schools](https://www.w3schools.com/java/default.asp)
- [Basic java collections tutorial](https://beginnersbook.com/java-collections-tutorials/)

# Future Work

- I want to fix the scoring system. Currently the score will auto-increment as long as you are drawing something. I have two ideas. One is to have you draw a image similar to another one and try and use a ml model to score how well you did. I think that would be too much work in this case. Therefore, the next case would be to incorporate a turn based drawing game instructions where you can rate your own drawing or have a judge rate it for you. It is difficult to rate it's quality. 
- I want to have a basic tutorial to show how to use the UI for users
- I want to make it so there is a creative mode. This should be pretty easy. I might just make it dark mode and let people color. This would be a kind of zen-mode
