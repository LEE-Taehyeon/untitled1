class OptionEx01 {
  def testOption(o:Option[Any]) = {
    val opt = o match {
      case Some(n) => n
      case None => "None"
    }
    opt
  }
}
