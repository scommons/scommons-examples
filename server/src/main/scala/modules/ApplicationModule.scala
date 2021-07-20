package modules

import controllers.Puzzle15Controller
import scaldi.Module

class ApplicationModule extends Module {
  
  bind[Puzzle15Controller] to injected[Puzzle15Controller]
}
