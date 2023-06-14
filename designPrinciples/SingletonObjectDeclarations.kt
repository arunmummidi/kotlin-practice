/* Object declarations 

You want to create a game and you decided to store the playing field in a PlayingField singleton. Inside this object, you added a Size singleton to store the field dimensions. This is a 2D game, so this object has the properties width and height.

Your field size can change, so you need to be able to resize it. For this, you decided to create the changeSize() function inside the PlayingField object. Complete this function! */

object PlayingField {
    object Size {
        var width: Int = 0
        var height: Int = 0
    }
    fun changeSize(newWidth: Int, newHeight: Int) {
        Size.width = newWidth
        Size.height = newHeight
    }
}