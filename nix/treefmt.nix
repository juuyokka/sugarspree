{ inputs, ... }:
let
  inherit (inputs) treefmt-nix;
in
{
  imports = [ treefmt-nix.flakeModule ];

  perSystem.treefmt = {
    projectRootFile = "flake.nix";
    programs.nixfmt.enable = true;
  };
}
